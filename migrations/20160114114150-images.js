var dbm = global.dbm || require('db-migrate');
var type = dbm.dataType;

exports.up = function(db, callback) {
  db.createTable('images', {
    id: {type: 'int', primaryKey: true},
    path: 'string',
    name: 'string',
    width: 'int',
    height: 'int',
    type: 'string',
    createdAt: 'int',
    updatedAt: 'int'
  }, callback);
};

exports.down = function(db, callback) {
  db.dropTable('images', callback);
};
