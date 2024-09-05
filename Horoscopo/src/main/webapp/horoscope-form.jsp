<!DOCTYPE html>
<html lang="en">
<head>
    <title>Formulario do Horoscopo</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <h2>Solicitar Horoscopo Diario</h2>
    <form action="horoscopo-servlet" method="post">
        <div class="form-group">
            <label for="birthdate">Data de Nascimento:</label>
            <input type="date" class="form-control" id="birthdate" name="birthdate" required>
        </div>
        <button type="submit" class="btn btn-primary">Obter Horóscopo</button>
    </form>
    <a href="logout-servlet" class="btn btn-danger mt-3">Logout</a>
</div>
</body>
</html>
