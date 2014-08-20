package kz.arta.ext.api.rest;

import kz.arta.ext.api.data.Dictionary;
import kz.arta.ext.api.data.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:42
 */
public abstract class AFormsReader extends RestQuery {
    public static final int maxCountPerList = 20;
    @Inject
    protected Logger log;

    protected static <T> List<Dictionary> convertToDictionaries(List<T> professions, IFieldGetter fieldGetter) {
        List<Dictionary> dictionaries = new ArrayList<Dictionary>();
        if (professions != null && professions.size() > 0) {
            int i = 1;
            Set<String> itemsSet = new HashSet<String>();
            for (T profession : professions) {
                if (profession != null) {
                    String keyField = fieldGetter.getKeyField(profession);
                    if (keyField != null) {
                        String keyFieldTrimmed = keyField.trim();
                        if (keyFieldTrimmed.length() > 0) {
                            String lowerKeyField = keyFieldTrimmed;//keyFieldTrimmed.toLowerCase();
                            if (!itemsSet.contains(lowerKeyField)) {
                                Dictionary dictionary = new Dictionary(fieldGetter.getId(i, profession), keyFieldTrimmed);
                                fieldGetter.prepareDictionary(dictionary, profession);
                                dictionaries.add(dictionary);
                                itemsSet.add(lowerKeyField);
                                i++;
                            }
                        }
                    }
                }
            }
            Collections.sort(dictionaries);
        }
        return dictionaries;
    }

    private static String createCondition(SearchParam param, String formUUID, String suffix) throws UnsupportedEncodingException {
        String cond =
                "&type" + suffix + "=partial" +
                        "&formUUID" + suffix + "=" + formUUID +
                        "&field" + suffix + "=" + param.getField() +
                        "&search" + suffix + "=" +
                        URLEncoder.encode(param.getCondition(), "utf-8");
        return cond;
    }

    public RegistryWrapper readRegistry(RestQueryContext queryContext, String formUUID, String searchField, String condition) {
        RegistryWrapper registryWrapper = null;
        try {
            if (condition == null) {
                condition = "";
            }
            String query = "/rest/api/asforms/search?" +
                    "type=partial" +
                    "&formUUID=" + formUUID +
                    "&field=" + searchField +
                    "&search=" +
                    URLEncoder.encode(condition, "utf-8")
                    + "&getDocIds=true&startRecord=0&recordsCount=1000000";

            String result = doGetQuery(queryContext, query);
            log.debug("result = {}", result);

            String registryJson = "{\"registryUUID\":\"" + formUUID + "\", \"records\":" + result + "}";
            log.debug("registryJson = {}", registryJson);

            ObjectMapper objectMapper = new ObjectMapper();
            registryWrapper = objectMapper.readValue(registryJson, RegistryWrapper.class);

            log.debug("registryWrapper = {}", registryWrapper);
            //registryWrapper.printRecords();

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return registryWrapper;
    }

    public RegistryWrapper readMultipleRegistry(RestQueryContext queryContext, String formUUID, SearchParam[] searchParams, SearchTerm term) {
        RegistryWrapper registryWrapper = null;
        try {
            if (searchParams != null && searchParams.length > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("/rest/api/asforms/search?getDocIds=true");
                sb.append(createCondition(searchParams[0], formUUID, ""));
                for (int i = 1; i < searchParams.length; i++) {
                    sb.append(createCondition(searchParams[i], formUUID, "" + i));
                }
                sb.append("&term=").append(term);
                sb.append("&startRecord=0&recordsCount=1000000");
                String query = sb.toString();

                String result = doGetQuery(queryContext, query);
                log.debug("result = {}",result);

                String registryJson = "{\"registryUUID\":\"" + formUUID + "\", \"records\":" + result + "}";
                log.debug("registryJson = {}", registryJson);

                ObjectMapper objectMapper = new ObjectMapper();
                registryWrapper = objectMapper.readValue(registryJson, RegistryWrapper.class);

                log.debug("registryWrapper = {}", registryWrapper);
            }
        } catch (Throwable e) {
            log.error("Error readMultipleRegistry formUUID {}", formUUID, e);
        }
        return registryWrapper;
    }

    public FormData readFormData(RestQueryContext context, String formId) {
        FormData formData = null;
        try {

            String query = "/rest/api/asforms/data/" + formId;
            String resultData = doGetQuery(context, query);
            log.debug("readFormData result  =  {}", resultData);

            String data = "";
            int startData = resultData.indexOf("[");
            if (startData >= 0) {
                int endData = resultData.lastIndexOf("]");
                data = resultData.substring(startData, endData + 1);
                resultData = resultData.substring(0, startData) + "\"\"" + resultData.substring(endData + 1);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            formData = objectMapper.readValue(resultData, FormData.class);
            formData.setData(data);
        } catch (Throwable e) {
            log.error("Error readFormData formId {}", formId, e);
        }
        return formData;
    }


    public void writeData(RestQueryContext queryContext, FormData formData) {
        log.debug("AFormsReader.writeData");
        try {
            String dataUUID = formData.getUuid();
//            dataUUID = "0"+dataUUID.substring(1);
            String formUUID = formData.getForm();
            String data = formData.getData();
            //Заполняем документ
            String saveFormQuery = String.format("/rest/api/asforms/data/save?formUUID=%s&uuid=%s",
                    formUUID, dataUUID);
            String saveResult = doPostQuery(queryContext, saveFormQuery, "\"data\":" + data);
            log.debug("writeData result = {}", saveResult);

        } catch (Throwable e) {
            log.error("Error writeData {}", formData, e);
        }
    }


    public RegistryRecord addNewRegistryRecord(RestQueryContext queryContext, String registryId) {
        RegistryRecord registryRecord = null;
        String query = "/rest/api/registry/create_doc?registryID=" + registryId;
        try {
            String result = doGetQuery(queryContext, query);
            log.debug("addNewRegistryRecord.result = " + result);
            ObjectMapper objectMapper = new ObjectMapper();
            registryRecord = objectMapper.readValue(result, RegistryRecord.class);

        } catch (IOException e) {
            log.error("Error addNewRegistryRecord {}", registryId, e);
        }
        return registryRecord;
    }


    public RegistryRecord activateRecord(RestQueryContext queryContext, String dataUUID) {
        RegistryRecord registryRecord = null;
        String query = String.format("/rest/api/registry/activate_doc?dataUUID=%S", dataUUID);
        try {
            String result = doGetQuery(queryContext, query);
            log.debug("activateRecord.result = {}", result);
            ObjectMapper objectMapper = new ObjectMapper();
            registryRecord = objectMapper.readValue(result, RegistryRecord.class);

        } catch (IOException e) {
            log.error("Error activateRecord {}", dataUUID, e);
        }
        return registryRecord;
    }
}
