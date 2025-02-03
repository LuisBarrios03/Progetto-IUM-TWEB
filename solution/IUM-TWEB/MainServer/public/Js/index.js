function initNavBar() {
    if (!sessionStorage.getItem("sessionActive")) {
        localStorage.removeItem("username"); // Cancella i dati salvati
        sessionStorage.setItem("sessionActive", "true"); // Imposta sessione attiva
    }

    let username = localStorage.getItem("username");
    let userSection = document.getElementById("userSection");
    if (username) {
        // Se l'utente ha fatto il login, mostra il nome utente e il pulsante logout
        userSection.innerHTML = `
            <div class="dropdown">
                <button class="btn btn-light dropdown-toggle me-5" type="button" id="userDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                    ${username}
                </button>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                    <li><a class="dropdown-item" href="#" onclick="logout()">Logout</a></li>
                </ul>
            </div>
        `;
    }
}

function logout() {
    localStorage.removeItem("username");
    window.location.href = "/"; // Reindirizza alla home dopo il logout
}
