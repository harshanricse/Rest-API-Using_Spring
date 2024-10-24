$(document).ready(
		function() {

			function tableCreate(el, data) {
				var tbl = document.createElement("table");
				tbl.border = 1;
				tbl.style.width = "70%";
				var tr1 = tbl.insertRow();
				tr1.bgColor = "pink";
				tr1.insertCell().appendChild(
						document.createTextNode("Customer Id"));
				tr1.insertCell().appendChild(
						document.createTextNode("Customer Name"));
				tr1.insertCell().appendChild(
						document.createTextNode("Customer Email Id"));
				for (var i = 0; i < data.length; ++i) {
					var tr = tbl.insertRow();
					for (var j = 0; j < data[i].length; ++j) {
						var td = tr.insertCell();
						td.appendChild(document.createTextNode(data[i][j]
								.toString()));
					}
				}
				$('table').attr('border', '0');
				$('.customer-table').append(tbl);

			}

			$.ajax({
				url : "http://localhost:8090/infytel/customers",
			}).then(function(data, status, jqxhr) {

				let rows = [];

				for (var i = 0; i < data.length; ++i) {
					let cells = [];
					cells.push(data[i].customerId);
					cells.push(data[i].customerName);
					cells.push(data[i].customerEmail);
					rows.push(cells);
				}
				tableCreate($("#customer-id"), rows);
				console.log(jqxhr);
			});
		});
