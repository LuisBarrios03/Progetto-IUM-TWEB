const socket = io();

// Recupera gli elementi HTML
const chatMessages = document.getElementById("chatMessages");
const messageInput = document.getElementById("messageInput");
const sendMessageBtn = document.getElementById("sendMessageBtn");
const chatUsername = document.getElementById("chatUsername");

// Recupera il nome utente dal localStorage (se esiste)
let username = localStorage.getItem("username") || "Anonimo";
chatUsername.textContent = username;

// Quando il bottone viene cliccato, invia il messaggio
sendMessageBtn.addEventListener("click", sendMessage);
messageInput.addEventListener("keypress", (event) => {
    if (event.key === "Enter" && !event.shiftKey) {
        event.preventDefault();
        sendMessage();
    }
});

// Funzione per inviare un messaggio
function sendMessage() {
    const message = messageInput.value.trim();
    if (message) {
        socket.emit("chat message", { username, message }); // Invia oggetto corretto
        messageInput.value = ""; // Svuota il campo dopo l'invio
    }
}

// Ascolta i messaggi dal server e aggiornali nella chat
socket.on("chat message", (data) => {
    console.log("Messaggio ricevuto dal server:", data); // Debug
    if (!data || !data.username || !data.message) {
        console.error("Errore: Messaggio ricevuto non valido", data);
        return;
    }

    const messageElement = document.createElement("div");
    messageElement.classList.add("d-flex", "flex-row", "mb-2");

    messageElement.innerHTML = `
        <div class="col-1">
            <img src="/img/account.png" alt="Immagine profilo" style="width: 60%; height: auto;">
        </div>
        <div class="col-11 d-flex flex-column">
            <h3>${data.username}</h3>
            <p>${data.message}</p>
        </div>
    `;

    chatMessages.appendChild(messageElement);
    chatMessages.scrollTop = chatMessages.scrollHeight; // Scorri automaticamente in basso
});
