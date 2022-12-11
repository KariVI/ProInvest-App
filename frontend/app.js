// Imports
const express = require('express')
const app = express()
const port = 5000

// Listen on Port 5000
app.use(express.static('public'));

app.set('views', './html');
app.set('view engine', 'ejs');
app.get('', (req, res) => {
    res.render('index', { text: 'Hey' })
})

app.get('/about', (req, res) => {
   res.sendFile(__dirname + '/html/login.html')
})

app.listen(port, () => console.info(`App listening on port ${port}`))