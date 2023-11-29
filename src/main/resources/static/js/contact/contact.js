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




