'use strict';


/**
 * Delete all products
 *
 * no response value expected for this operation
 **/
exports.productsDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve all products
 *
 * no response value expected for this operation
 **/
exports.productsGET = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Delete specific product
 *
 * no response value expected for this operation
 **/
exports.productsIdDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve specific product
 *
 * returns Product
 **/
exports.productsIdGET = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "price" : "",
  "name" : "",
  "description" : "",
  "id" : "",
  "supplier_id" : "",
  "quantity_available" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Update existing product
 *
 * body Products_id_body 
 * no response value expected for this operation
 **/
exports.productsIdPATCH = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Create a new product
 *
 * body Product 
 * returns Product
 **/
exports.productsPOST = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "price" : "",
  "name" : "",
  "description" : "",
  "id" : "",
  "supplier_id" : "",
  "quantity_available" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Replace all prodcuts with a new collection
 *
 * body  
 * no response value expected for this operation
 **/
exports.productsPUT = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}

