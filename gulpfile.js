var gulp       = require('gulp');
var gulpCoffee = require('gulp-coffee');
var gulpConcat = require('gulp-concat');
var gulpIf     = require('gulp-if');
var gulpUglify = require('gulp-uglify');
var env        = require('./env');

var paths = {
  scripts: ['src/main/webapp/assets/scripts/**.coffee']
};

gulp.task('scripts', function() {
  return gulp.src(paths.scripts)
       .pipe(gulpCoffee())
       .pipe(gulpIf(env.compressFiles, gulpUglify()))
       .pipe(gulpConcat('out.min.js'))
       .pipe(gulp.dest('src/main/webapp/assets/scripts'));
});

gulp.task('watch', function() {
  gulp.watch(paths.scripts, ['scripts']);
});

gulp.task('default', ['scripts', 'watch']);
