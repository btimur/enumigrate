'use strict';

/* Services */

var services = angular.module('migrate.services', ['ngResource']);

services.factory('MigrateFactory', function ($resource) {
//    url = url || '/migrate/rest/jurnal/status';
    return function(pathUrl){
        return $resource(pathUrl, {}, {
            query: {
                method: 'GET',
                params: {},
                isArray: false
            }
        })
    }

});
