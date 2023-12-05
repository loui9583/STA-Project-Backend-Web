async function sendEmail() {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const subject = document.getElementById("subject").value;
    const message = document.getElementById("message").value;
    const formString = `Name: ${name}. Email: ${email}. Subject: ${subject}. Message: ${message}`

    const response = await fetch("api/sendEmail/user-email/" + email + "/email-content/" + formString + "/customer-name/" + name, {
        method: 'POST',
    });
}

async function sendEmail2() {
    const fullName = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phoneNumber = document.getElementById("phone-number").value;
    const address = document.getElementById("address").value;
    const course = document.getElementById("course-type").value;
    const licenseCountry = document.getElementById("license-country").value;
    const license = document.getElementById("license").value;
    const ratingExpiryDate = document.getElementById("rating-expiry-date").value;
    const flightHours = document.getElementById("flight-hours").value;
    const lastFlightDate = document.getElementById("last-flight-date").value;
    const otherMPA = document.getElementById("otherMPA").value;
    const otherBPN = document.getElementById("otherBPN").value;
    const position = document.getElementById("position").value;
    const venue = document.getElementById("venue").value;
    const message = document.getElementById("message").value;
    const formString = 'Name: ' + fullName + '. Email: ' + email + '. Phone Number: ' + phoneNumber + '. Address: ' + address + '. Course: ' + course + '. License Country: ' + licenseCountry + '. License: ' + license + '. Rating Expiry Date: ' + ratingExpiryDate + '. Flight Hours: ' + flightHours + '. Last Flight Date: ' + lastFlightDate + '. Other MPA: ' + otherMPA + '. Other BPN: ' + otherBPN + '. Position: ' + position + '. Venue: ' + venue + '. Message: ' + message;

    const response = await fetch("api/sendEmail/user-email/" + email + "/email-content/" + formString + "/customer-name/" + fullName, {
        method: 'POST',
    });
}




