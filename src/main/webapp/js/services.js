'use strict';

/* Services */

var services = angular.module('migrate.services', ['ngResource']);

services.factory('MigrateFactory', function ($resource) {
    return $resource('/migrate/rest/jurnal/status', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    })
});
