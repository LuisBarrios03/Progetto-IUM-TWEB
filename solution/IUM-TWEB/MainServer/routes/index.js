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

router.get('/FilmScheda', function(req, res, next) {
  res.render('Pages/FilmScheda.hbs', { title: 'Register', showSearch: false });
})
router.get('/FilmSearched', async function(req, res, next) {
  try {
    let queryString = Object.entries(req.query)
        .map(([key, value]) => `${key}=${encodeURIComponent(value)}`)
        .join("&");

    let response = await axios.get(`http://localhost:8080/movies/search?${queryString}`);
    let movies = response.data;

    res.render('Pages/FilmSearched', {
      title: 'Results',
      showSearch: false,
      movies: movies
    });

  } catch (error) {
    console.error("Errore nel caricamento dei film:", error);
    res.render('Pages/FilmSearched', {
      title: 'Results',
      showSearch: false,
      movies: [],
      error: "Errore nel caricamento dei film."
    });
  }

})

module.exports = router;
