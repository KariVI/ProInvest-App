// Imports
const express = require('express')
const app = express()
const port = 5000

// Static Files
app.use(express.static('public'));
// Specific folder example
// app.use('/css', express.static(__dirname + 'public/css'))
// app.use('/js', express.static(__dirname + 'public/js'))
// app.use('/img', express.static(__dirname + 'public/images'))

// Set View's
app.set('views', './views');
app.set('view engine', 'ejs');

app.get('', (req, res) => {
    res.sendFile(__dirname + '/views/login.html')
 })

 app.get('/usuario', (req, res) => {
    res.sendFile(__dirname + '/views/registerUser.html')
 })

 app.get('/principal', (req, res) => {
    res.sendFile(__dirname + '/views/simulateInversion.html')
 })
 app.get('/inversor', (req, res) => {
    res.sendFile(__dirname + '/views/registerInversor.html')
 })
 app.get('/domicilio', (req, res) => {
    res.sendFile(__dirname + '/views/registerDirection.html')
 })
 app.get('/infoFinanciera', (req, res) => {
    res.sendFile(__dirname + '/views/registerInfoFinancial.html')
 })
app.listen(port, () => console.info(`App listening on port ${port}`))