var express = require('express');
var router = express.Router();
var controllerData = require('../Controller/controllersData');
/* Post home page. */
router.get('/api/dataRotten',controllerData.getAllDataRottenTomatoes);
router.get('/api/dataOscar',controllerData.getAllDataTheOscarAwards);
router.get('/api/20dataOscar',controllerData.get100OscarAwards);
router.get('/api/findOscar',controllerData.getOscars);

module.exports = router;
