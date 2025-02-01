var express = require('express');
var router = express.Router();
var controllerData = require('../Controller/controllersData');
/* Post home page. */
router.get('/api/dataRotten',controllerData.getAllDataRottenTomatoes);
router.get('/api/dataOscar',controllerData.getAllDataTheOscarAwards);
router.get('/api/20dataOscar',controllerData.get20OscarAwards);

module.exports = router;
