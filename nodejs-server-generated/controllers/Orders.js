'use strict';

var utils = require('../utils/writer.js');
var Orders = require('../service/OrdersService');

module.exports.ordersDELETE = function ordersDELETE (req, res, next) {
  Orders.ordersDELETE()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.ordersGET = function ordersGET (req, res, next) {
  Orders.ordersGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.ordersIdDELETE = function ordersIdDELETE (req, res, next) {
  Orders.ordersIdDELETE()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.ordersIdGET = function ordersIdGET (req, res, next) {
  Orders.ordersIdGET()
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.ordersIdPATCH = function ordersIdPATCH (req, res, next, body) {
  Orders.ordersIdPATCH(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.ordersPOST = function ordersPOST (req, res, next, body) {
  Orders.ordersPOST(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};

module.exports.ordersPUT = function ordersPUT (req, res, next, body) {
  Orders.ordersPUT(body)
    .then(function (response) {
      utils.writeJson(res, response);
    })
    .catch(function (response) {
      utils.writeJson(res, response);
    });
};
