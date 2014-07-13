'use strict';

/* Controllers */


var app = angular.module('migrate.controllers', []);


app.controller('JurnalCtrl',  function ($scope, $interval, MigrateFactory) {
    $scope.bla = 'bla from controller';
    function refresh() {
        return $interval(function () {
            MigrateFactory.get({}, function (migrateFactory) {
                $scope.isStarted = migrateFactory.isStarted;
                $scope.countDid = migrateFactory.countDid;
                $scope.countAll = migrateFactory.countAll;
                $scope.procent = migrateFactory.procent;
            });
            console.log('interval fired');
        }, 1000);
    }
    function destroyTimer() {
        $interval.cancel(intervalPromise);
        intervalPromise = null;
    }
    var intervalPromise = refresh();
    $scope.$on('$destroy', function () {
        destroyTimer();
    });


    $scope.startMigrate = function() {
        console.log('start migrate');
        $scope.isStarted = true;
        if(intervalPromise == null){
            intervalPromise = refresh();
        }

    };

    $scope.endMigrate = function() {
        console.log('end migrate');
        $scope.isStarted = false;
        destroyTimer();
    };
});
