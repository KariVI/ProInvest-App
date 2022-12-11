


document.addEventListener("DOMContentLoaded", function () {
    let xValues = ["Italy", "France", "Spain", "USA", "Argentina"];
    let yValues = [55, 49, 44, 24, 15];
    let barColors = "#91EAE4";
    const ctx = document.getElementById("myChart")
    new Chart(ctx, {
        type: "bar",
        data: {
          labels: xValues,
          datasets: [{
            backgroundColor: barColors,
            data: yValues
          }]
        },
        options: {
          legend: {display: false},
          title: {
            display: true,
            text: "Rendimiento de la inversión"
          }
        }
      });
})

