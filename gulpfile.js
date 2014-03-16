const gulp          = require('gulp');
const gulpCoffee    = require('gulp-coffee');
const gulpConcat    = require('gulp-concat');
const gulpIf        = require('gulp-if');
const gulpMinifyCss = require('gulp-minify-css');
const gulpStylus    = require('gulp-stylus');
const gulpUglify    = require('gulp-uglify');
const env           = require('./env');

const ASSETS_PATH       = 'src/main/webapp/assets/';
const SCRIPTS_BASE_PATH = ASSETS_PATH + 'scripts/';
const STYLES_BASE_PATH  = ASSETS_PATH + 'styles/';

const PATHS = {
  scripts: [SCRIPTS_BASE_PATH + '**.coffee'],
  styles:  [STYLES_BASE_PATH  + '**.styl']
};

gulp.task('scripts', function() {
  return gulp.src(PATHS.scripts)
       .pipe(gulpCoffee())
       .pipe(gulpIf(env.compressFiles, gulpUglify()))
       .pipe(gulpConcat('out.js'))
       .pipe(gulp.dest(SCRIPTS_BASE_PATH));
});

gulp.task('styles', function() {
   return gulp.src(PATHS.styles)
       .pipe(gulpStylus())
       .pipe(gulpMinifyCss())
       .pipe(gulpConcat('out.css'))
       .pipe(gulp.dest(STYLES_BASE_PATH));
});

gulp.task('watch', function() {
  gulp.watch(PATHS.scripts, ['scripts']);
  gulp.watch(PATHS.styles,  ['styles']);
});

gulp.task('default', ['scripts', 'styles', 'watch']);
