var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('Pages/HomePage.hbs', { title: 'Express' });
});

/* GET film. */
router.get('/Film', function(req, res, next) {
  res.render('Pages/Film.hbs', { title: 'Express' });
});
router.get('/Oscars', function(req, res, next) {
  res.render('Pages/Oscars.hbs', { title: 'Express' });
});

module.exports = router;
