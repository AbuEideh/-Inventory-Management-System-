'use strict';


/**
 * Delete all inventories
 *
 * no response value expected for this operation
 **/
exports.inventoriesDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve all inventories
 *
 * no response value expected for this operation
 **/
exports.inventoriesGET = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Delete specific inventory
 *
 * no response value expected for this operation
 **/
exports.inventoriesIdDELETE = function() {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Retrieve speicific inventory
 *
 * returns Inventory
 **/
exports.inventoriesIdGET = function() {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "quantity" : "",
  "last_restock_date" : "",
  "product_id" : "",
  "location" : "",
  "id" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Update existing inventory
 *
 * body Inventories_id_body 
 * no response value expected for this operation
 **/
exports.inventoriesIdPATCH = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}


/**
 * Create a new inventory
 *
 * body Inventory 
 * returns Inventory
 **/
exports.inventoriesPOST = function(body) {
  return new Promise(function(resolve, reject) {
    var examples = {};
    examples['application/json'] = {
  "quantity" : "",
  "last_restock_date" : "",
  "product_id" : "",
  "location" : "",
  "id" : ""
};
    if (Object.keys(examples).length > 0) {
      resolve(examples[Object.keys(examples)[0]]);
    } else {
      resolve();
    }
  });
}


/**
 * Replace all inventories
 *
 * body  
 * no response value expected for this operation
 **/
exports.inventoriesPUT = function(body) {
  return new Promise(function(resolve, reject) {
    resolve();
  });
}

