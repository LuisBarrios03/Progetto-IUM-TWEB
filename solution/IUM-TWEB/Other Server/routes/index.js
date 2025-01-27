var express = require('express');
var router = express.Router();
var controllerData = require('../Controller/controllersData');
/* Post home page. */
router.get('/api/data',controllerData.getAllData);
module.exports = router;
