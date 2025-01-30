var express = require('express');
var router = express.Router();
const axios = require('axios');
/* GET home page. */
router.get('/', async function (req, res, next) {
  res.render('Pages/HomePage.hbs', {title: 'Awards Explorer'});


});

/* GET film. */
router.get('/Films', function(req, res, next) {
  res.render('Pages/Films.hbs', { title: 'Films' });
});

router.get('/Oscars', function(req, res, next) {
  res.render('Pages/Oscars.hbs', { title: 'Oscars' });
});

module.exports = router;
