function returnHome() {
    let username = document.getElementById("user").value.trim();

    if (username) {
        localStorage.setItem("username", username); // Salva il nome utente
        window.location.href = "/"; // Cambia con il percorso della tua home
    } else {
        alert("Inserisci un nome utente!");
    }
}
