'use strict';

var utils = require('../utils/writer.js');
var Inventories = require('../service/InventoriesService');

module.exports.inventoriesDELETE = function inventoriesDELETE (req, res, next) {
  Inventories.inventoriesDELETE()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.inventoriesGET = function inventoriesGET (req, res, next) {
  Inventories.inventoriesGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.inventoriesIdDELETE = function inventoriesIdDELETE (req, res, next) {
  Inventories.inventoriesIdDELETE()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.inventoriesIdGET = function inventoriesIdGET (req, res, next) {
  Inventories.inventoriesIdGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.inventoriesIdPATCH = function inventoriesIdPATCH (req, res, next, body) {
  Inventories.inventoriesIdPATCH(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.inventoriesPOST = function inventoriesPOST (req, res, next, body) {
  Inventories.inventoriesPOST(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.inventoriesPUT = function inventoriesPUT (req, res, next, body) {
  Inventories.inventoriesPUT(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
