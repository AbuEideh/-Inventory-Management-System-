'use strict';

var utils = require('../utils/writer.js');
var Suppliers = require('../service/SuppliersService');

module.exports.suppliersDELETE = function suppliersDELETE (req, res, next) {
  Suppliers.suppliersDELETE()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.suppliersGET = function suppliersGET (req, res, next) {
  Suppliers.suppliersGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.suppliersIdDELETE = function suppliersIdDELETE (req, res, next) {
  Suppliers.suppliersIdDELETE()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.suppliersIdGET = function suppliersIdGET (req, res, next) {
  Suppliers.suppliersIdGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.suppliersIdPATCH = function suppliersIdPATCH (req, res, next, body) {
  Suppliers.suppliersIdPATCH(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.suppliersPOST = function suppliersPOST (req, res, next, body) {
  Suppliers.suppliersPOST(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.suppliersPUT = function suppliersPUT (req, res, next, body) {
  Suppliers.suppliersPUT(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
