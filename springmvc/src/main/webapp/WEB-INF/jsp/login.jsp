<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/font-awesome.css" >
		<script src="js/jquery-3.3.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<div class="border border-primary col-sm-12 col-md-6 col-lg-3" style="margin: 0 auto;">
			<form method="post" action="login/authenticate">
				<h1> Login Form </h1>
				<div class="form-group">
					<label for="usernameText">User name</label>
					<input id="usernameText" class="form-control"  name="username1" type="text" />
				</div>
				<div class="form-group">
					<label for="passwordText">Password</label>
					<input id="passwordText" class="form-control" name="password1" type="password"  />
				</div>
				<div class="float-right">
					<button class="btn btn-primary loginAction " type="submit" > Login </button>
				</div>
			</form>
		</div>
			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog" role="document">
				<div class="modal-content">
				  <div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					  <span aria-hidden="true">&times;</span>
					</button>
				  </div>
				  <div class="modal-body">
					...
				  </div>
				  <div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
					<button type="button" id="confirmYes" class="btn btn-primary">Yes</button>
				  </div>
				</div>
			  </div>
			</div>
			<script>
			/*$('form div button.loginAction').on("click",function(event){
					var username = $('#usernameText').val();
					var password = $('#passwordText').val();
					if(username=='admin' && password=='123'){
						alert('login ok.')
					}else{
						alert('login failure.')
					}
				});*/
			</script>
		</div>
	</body>
</html>