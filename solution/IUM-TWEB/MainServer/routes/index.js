var express = require('express');
var router = express.Router();
const axios = require('axios');
/* GET home page. */
router.get('/', async function (req, res, next) {
  res.render('Pages/HomePage.hbs', {title: 'Awards Explorer', showSearch: true});
});

/* GET film. */
router.get('/Films', function(req, res, next) {
  res.render('Pages/Films.hbs', { title: 'Films', showSearch: true });
});

router.get('/Oscars', function(req, res, next) {
  res.render('Pages/Oscars.hbs', { title: 'Oscars', showSearch: true });
});

router.get('/Login', function(req, res, next) {
  res.render('Pages/Login.hbs', { title: 'Login', showSearch: false });
});

module.exports = router;
