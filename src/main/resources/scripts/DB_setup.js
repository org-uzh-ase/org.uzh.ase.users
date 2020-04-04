//Run this script in the command line with the Mongo Shell: mongo < DB_setup.js
use usersdb
db.dropDatabase()
db.createCollection("user")
db.user.createIndex( { name: -1 } )
db.createCollection("score")
db.createCollection("session")
db.session.createIndex( { userId: -1 } )