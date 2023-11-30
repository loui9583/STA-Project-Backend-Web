document.addEventListener('DOMContentLoaded', function () {
    fetch('/html/elements/footer.html')
      .then(response => response.text())
      .then(data => {
        document.getElementById('footer-container').innerHTML = data;
      });
  });

  document.addEventListener('DOMContentLoaded', function () {
    fetch('/html/elements/navbar.html')
      .then(response => response.text())
      .then(data => {
        document.getElementById('navbar-container').innerHTML = data;
      });
  });