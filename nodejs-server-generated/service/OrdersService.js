'use strict';


/**
 * Delete all orders
 *
 * no response value expected for this operation
 **/
exports.ordersDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve all orders
 *
 * no response value expected for this operation
 **/
exports.ordersGET = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Delete specific order
 *
 * no response value expected for this operation
 **/
exports.ordersIdDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve specific order
 *
 * returns Order
 **/
exports.ordersIdGET = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "order_date" : "",
  "order_status" : "",
  "delivery_date" : "",
  "quantity" : "",
  "id" : "",
  "supplier_id" : "",
  "products" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Update existing order
 *
 * body Orders_id_body 
 * no response value expected for this operation
 **/
exports.ordersIdPATCH = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Create a new order
 *
 * body Order 
 * returns Order
 **/
exports.ordersPOST = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "order_date" : "",
  "order_status" : "",
  "delivery_date" : "",
  "quantity" : "",
  "id" : "",
  "supplier_id" : "",
  "products" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Replace all orders
 *
 * body  
 * no response value expected for this operation
 **/
exports.ordersPUT = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}

