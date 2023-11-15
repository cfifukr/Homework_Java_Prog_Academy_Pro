<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Form</title>
  </head>
  <body>
    <form method="post" id="form1" action = "form">
      <h2 class="text-center">What is ur gender?</h2>
      <select class="form-select" name = "gender" aria-label="Default select example">

        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="mechanic">Gender? Im a mechanic</option>
        <option value="privateInformation">Private Information</option>
      </select>
      <p>Gender? Im a mechanic - <a href="https://www.tiktok.com/@ceoofmemes/video/7219370710001667334?lang=en">LINK</a></p>
      <br>
      <h2 class="text-center" >What is ur occupation?</h2>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="occupation" value="schoolboy" id="check">
        <label class="form-check-label" for="check">
          Im a schoolboy(Not working)
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="occupation"value="student" id="check2">
        <label class="form-check-label" for="check2">
          Im a student(Not working)
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="occupation" value="employed" id="check3" >
        <label class="form-check-label" for="check3">
          I have a job
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="occupation" value="unemployed" id="check4">
        <label class="form-check-label" for="check4">
          Im unemployed
        </label>
      </div>

      <br>
      <button class="btn btn-dark">Submit form</button>
    </form>
  </body>
</html>