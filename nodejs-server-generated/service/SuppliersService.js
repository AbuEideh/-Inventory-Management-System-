'use strict';


/**
 * Delete all suppliers
 *
 * no response value expected for this operation
 **/
exports.suppliersDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve all suppliers
 *
 * no response value expected for this operation
 **/
exports.suppliersGET = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Delete specific supplier
 *
 * no response value expected for this operation
 **/
exports.suppliersIdDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve specific supplier
 *
 * returns Supplier
 **/
exports.suppliersIdGET = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "address" : "",
  "phone" : "",
  "name" : "",
  "id" : "",
  "email" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Update existing supplier
 *
 * body Suppliers_id_body 
 * no response value expected for this operation
 **/
exports.suppliersIdPATCH = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Create a new supplier
 *
 * body Suppliers_body 
 * returns Supplier
 **/
exports.suppliersPOST = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "address" : "",
  "phone" : "",
  "name" : "",
  "id" : "",
  "email" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Replace all suppliers with new collection
 *
 * body  
 * no response value expected for this operation
 **/
exports.suppliersPUT = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}

