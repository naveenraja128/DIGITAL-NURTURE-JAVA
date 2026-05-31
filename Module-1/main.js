

console.log("Welcome to the Community Portal");

window.onload = () => {
    alert("Community Portal Loaded");
    loadPreference();
    displayEvents();
};


const events = [
    { name: "Music Festival", category: "Music", seats: 20 },
    { name: "Baking Workshop", category: "Workshop", seats: 15 },
    { name: "Football Tournament", category: "Sports", seats: 10 }
];


function displayEvents(list = events) {

    const container =
        document.getElementById("eventContainer");

    if (!container) return;

    container.innerHTML = "";

    list.forEach((event, index) => {

        const card = document.createElement("div");
        card.className = "eventCard";

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>${event.category}</p>
            <p>Seats: ${event.seats}</p>
            <button onclick="registerEvent(${index})">
                Register
            </button>
        `;

        container.appendChild(card);
    });
}


function registerEvent(index) {

    try {

        if (events[index].seats <= 0) {
            throw "No Seats Available";
        }

        events[index].seats--;
        alert("Registration Successful");

        displayEvents();

    } catch (error) {

        alert(error);

    }
}


document.getElementById("categoryFilter")
?.addEventListener("change", function () {

    const value = this.value;

    if (value === "all") {
        displayEvents();
        return;
    }

    const filtered =
        events.filter(
            event => event.category === value
        );

    displayEvents(filtered);

});


document.getElementById("searchBox")
?.addEventListener("keyup", function () {

    const keyword =
        this.value.toLowerCase();

    const result =
        events.filter(event =>
            event.name.toLowerCase()
            .includes(keyword)
        );

    displayEvents(result);

});


document.getElementById("registrationForm")
?.addEventListener("submit", function (event) {

    event.preventDefault();

    document.getElementById(
        "registrationOutput"
    ).innerHTML =
        "Registration Successful";

});


document.getElementById("phone")
?.addEventListener("blur", function () {

    if (!/^\d{10}$/.test(this.value)) {
        alert("Enter valid phone number");
    }

});


document.getElementById("feeSelector")
?.addEventListener("change", function () {

    document.getElementById(
        "feeDisplay"
    ).innerHTML =
        "Event Fee : ₹" + this.value;

});

document.getElementById("feedbackBox")
?.addEventListener("keyup", function () {

    document.getElementById(
        "charCount"
    ).innerHTML =
        "Characters: " + this.value.length;

});

function submitFeedback() {
    alert("Feedback Submitted");
}

function enlargeImage(img) {
    img.style.transform = "scale(1.2)";
}

document.getElementById("promoVideo")
?.addEventListener("canplay", function () {

    document.getElementById(
        "videoMessage"
    ).innerHTML =
        "Video Ready To Play";

});

function savePreference() {

    const value =
        document.getElementById(
            "eventPreference"
        ).value;

    localStorage.setItem(
        "preferredEvent",
        value
    );

    alert("Preference Saved");
}

function loadPreference() {

    const saved =
        localStorage.getItem(
            "preferredEvent"
        );

    if (saved) {
        document.getElementById(
            "eventPreference"
        ).value = saved;
    }
}

function clearPreferences() {

    localStorage.clear();
    sessionStorage.clear();

    alert("Preferences Cleared");
}

function findLocation() {

    navigator.geolocation.getCurrentPosition(

        position => {

            document.getElementById(
                "locationResult"
            ).innerHTML =
                `Latitude: ${position.coords.latitude}
                 <br>
                 Longitude: ${position.coords.longitude}`;

        },

        () => {

            document.getElementById(
                "locationResult"
            ).innerHTML =
                "Location Access Denied";

        }

    );
}

fetch("https://jsonplaceholder.typicode.com/posts/1")
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.log(error));

window.onbeforeunload = () =>
    "Are you sure you want to leave?";

$(document).ready(function () {

    $("#registerBtn").click(function () {

        $(".eventCard")
            .fadeOut(200)
            .fadeIn(200);

    });

});
