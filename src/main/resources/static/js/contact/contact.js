async function sendEmail() {
    const privacyPolicyCheckbox = document.getElementById("privacyPolicy");
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const subject = document.getElementById("subject").value;
    const message = document.getElementById("message").value;
    const formString = `Name: ${name}. Email: ${email}. Subject: ${subject}. Message: ${message}`

    if (!privacyPolicyCheckbox.checked) {
        alert("Please agree to the Privacy Policy before submitting the form.");
        return;
    }

    if (privacyPolicyCheckbox.checked) {
        const response = await fetch("api/sendEmail/user-email/" +
            email + "/email-content/" + formString + "/customer-name/" + name, {
            method: 'POST',
        });
    }
}

async function sendEmail2() {
    try {
        const fullName = document.getElementById("name").value;
        const email = document.getElementById("email").value;
        const phoneNumber = document.getElementById("phone-number").value;
        const address = document.getElementById("address").value;
        const course = document.getElementById("course-type").value;
        const courseOther = document.getElementById("course-type-other").value;
        const licenseCountry = document.getElementById("license-country").value;
        const license = document.getElementById("license").value;
        const ratingExpiryDate = document.getElementById("rating-expiry-date").value;
        const flightHours = document.getElementById("flight-hours").value;
        const lastFlightDate = document.getElementById("last-flight-date").value;
        const otherMPA = document.getElementById("otherMPA").value;
        const pbnEndorsement = document.getElementById("pbnEndorsement").value;
        const position = document.getElementById("position").value;
        const venue = document.getElementById("venue").value;
        const date = document.getElementById("date").value;
        const message = document.getElementById("message").value;


        const formString = `Name: ${fullName}. 
        Email: ${email}. Phone Number: ${phoneNumber}. 
        Address: ${address}. 
        Course: ${course}. 
        Optional Other Course: ${courseOther}
        License Country: ${licenseCountry}. 
        License: ${license}. 
        Rating Expiry Date: ${ratingExpiryDate}. 
        Flight Hours: ${flightHours}. 
        Last Flight Date: ${lastFlightDate}. 
        Active or Other MPA: ${otherMPA}. 
        BPN Endorsement: ${pbnEndorsement}. 
        Position: ${position}. 
        Venue: ${venue}. 
        Date: ${date},
        Message: ${message}`;

        const response = await fetch("api/sendEmail/user-email/" + email + "/email-content/" + formString + "/customer-name/" + fullName, {
            method: 'POST',
        });

        if (!response.ok) {
            const errorMessage = `Failed to send email. Server responded with status ${response.status}: ${response.statusText}`;
            throw new Error(errorMessage);
        }

        // Handle the result as needed (e.g., show success message, redirect, etc.)
        console.log('Email sent successfully:');
    } catch (error) {
        // Handle errors
        console.error('Error sending email:', error.message);
        // You can show an error message to the user, redirect, or perform other actions.

    }
}





