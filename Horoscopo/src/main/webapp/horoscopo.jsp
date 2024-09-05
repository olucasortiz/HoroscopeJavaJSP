<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Horóscopo Diário</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-3">
    <h2>Seu Horoscopo Diario</h2>
    <div class="card mt-3">
        <div class="card-header">
            <h3>Signo: ${signo}</h3>
        </div>
        <div class="card-body">
            <p class="card-text">${horoscopo}</p>
        </div>
        <div class="card-body">
            <img src="image/${image}" alt="${signo} image" class="img-fluid">

        </div>
    </div>
    <%
        String imagePath = "images/" + (String) request.getAttribute("image");
        System.out.println("Caminho da imagem na JSP: " + imagePath);
    %>

    <img src="<%= imagePath %>" alt="${signo} image" class="img-fluid">

    <a href="horoscope-form.jsp" class="btn btn-primary mt-3">Voltar</a>
    <a href="logout-servlet" class="btn btn-danger mt-3">Logout</a>
</div>
</body>
</html>
