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
  res.render('Pages/FilmScheda.hbs', { title: 'Film', showSearch: false });
})

router.get('/FilmSearched', async function(req, res, next) {
  try {
    // Estrai i parametri della query string
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
    // Verifica che la risposta non sia già stata inviata prima di inviarne un'altra
    if (!res.headersSent) {
      console.error("Errore nel caricamento dei film:", error);
      // In caso di errore, passa una lista vuota di film e un messaggio di errore
      res.render('Pages/FilmSearched', {
        title: 'Results',
        showSearch: false,
        movies: [],
        error: "Errore nel caricamento dei film."
      });
    }
  }
});

module.exports = router;
