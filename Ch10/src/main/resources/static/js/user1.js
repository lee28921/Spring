	
			$(function(){
				
				// User1
				$('#btnUser1s').click(function(){
					
					$.ajax({
						url: '/Ch10/user1',
						type: 'GET',
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				$('#btnUser1').click(function(){
					$.ajax({
						url: '/Ch10/user1/A102',
						type: 'GET',
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
					});
				});
				$('#btnUser1Register').click(function(){
					
					const jsonData = {
						id:"A110",
						name:"홍길동",
						hp:"010-2222-1234",
						age:31
					};
					
					$.ajax({
						url: '/Ch10/user1',
						type: 'POST',
						data: jsonData,
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
					});
				});
				$('#btnUser1Modify').click(function(){
					const jsonData = {
						id:"A110",
						name:"홍길동",
						hp:"010-2222-1001",
						age:23
					};
					
					$.ajax({
						url: '/Ch10/user1',
						type: 'PUT',
						data: jsonData,
						dataType: 'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				$('#btnUser1Delete').click(function(){
					$.ajax({
						url: '/Ch10/user1/A110',
						type: 'DELETE',
						dataType: 'json',
						success: function(data){
							console.log(data);							
						}
						
					});
				});
				
			});