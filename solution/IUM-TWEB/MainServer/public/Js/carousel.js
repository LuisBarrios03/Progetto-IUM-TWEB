document.addEventListener("DOMContentLoaded", function () {
    console.log('DOMContentLoaded');
    const carouselInner = document.getElementById("carousel-inner");
    const carouselIndicators = document.getElementById("carousel-indicators");

    axios.get("http://localhost:8080/movies/recent")
        .then(response => {
            const films = response.data;
            console.log(films);
            films.forEach((film, index) => {
                // Creazione indicatori del carosello
                const indicator = document.createElement("button");
                indicator.type = "button";
                indicator.setAttribute("data-bs-target", "#carouselExampleCaptions");
                indicator.setAttribute("data-bs-slide-to", index);
                indicator.setAttribute("aria-label", `Slide ${index + 1}`);
                if (index === 0) indicator.classList.add("active");

                carouselIndicators.appendChild(indicator);

                // Creazione della card del carosello
                const carouselItem = document.createElement("div");
                carouselItem.classList.add("carousel-item");
                if (index === 0) carouselItem.classList.add("active");

                carouselItem.innerHTML = `
                    <img src="${film.posterUrl}" class="d-block w-100" alt="${film.name}">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>${film.name}</h5>
                        <p><strong>${film.tagline}</strong></p>
                        <p>${film.description} - ${film.minute} min - ⭐ ${film.rating}</p>
                    </div>
                `;

                carouselInner.appendChild(carouselItem);
            });
        })
        .catch(error => {
            console.error("Errore nel caricamento dei film:", error);
        });
});
