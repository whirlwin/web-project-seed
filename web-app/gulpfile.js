const gulp          = require('gulp');
const gulpCoffee    = require('gulp-coffee');
const gulpConcat    = require('gulp-concat');
const gulpIf        = require('gulp-if');
const gulpJade      = require('gulp-jade');
const gulpMinifyCss = require('gulp-minify-css');
const gulpStylus    = require('gulp-stylus');
const gulpUglify    = require('gulp-uglify');
const env           = require('./env');

const ASSETS_PATH        = 'src/main/webapp/assets/';
const CUSTOM_COFFEE_PATH = ASSETS_PATH + 'scripts/**/*.coffee';
const CUSTOM_STYLUS_PATH = ASSETS_PATH + 'styles/**/*.styl';
const CUSTOM_JADE_PATH   = ASSETS_PATH + 'views/**/*.jade';

const JS_LIBS = {
  "angular":       {main: "angular.js",           min: "angular.min.js"},
  "angular-route": {main: "angular-route.js",     min: "angular-route.min.js"},
  "jquery":        {main: "dist/jquery.js",       min: "dist/jquery.min.js"},
  "bootstrap":     {main: "dist/js/bootstrap.js", min: "dist/js/bootstrap.min.js"}
};

const CSS_LIBS = {
  "bootstrap": {main: "dist/css/bootstrap.css", min: "bootstrap.min.css"}
};

function getLibPaths(libs) {
  return Object.keys(libs).map(function(libName) {
    return ASSETS_PATH + 'lib/' + libName + '/' +(env.compressed ? libs[libName].min : libs[libName].main);
  });
}

gulp.task('customCoffee', function() {
  return gulp.src(CUSTOM_COFFEE_PATH)
      .pipe(gulpCoffee())
      .pipe(gulpIf(env.compressed, gulpUglify()))
      .pipe(gulpConcat('custom.js'))
      .pipe(gulp.dest(ASSETS_PATH + 'dist/js/'));
});

gulp.task('libJs', function() {
  return gulp.src(getLibPaths(JS_LIBS))
      .pipe(gulpConcat('libs.js'))
      .pipe(gulp.dest(ASSETS_PATH + 'dist/js/'))
});

// Combine custom scripts and library scripts into one file, depends on the handling of custom and library JS
gulp.task('combineJs', ['customCoffee', 'libJs'], function() {
  return gulp.src([ASSETS_PATH + 'dist/js/{libs.js,custom.js}'])
      .pipe(gulpConcat('all.js'))
      .pipe(gulp.dest(ASSETS_PATH + 'dist/js/'));
});

gulp.task('customStylus', function() {
  return gulp.src(CUSTOM_STYLUS_PATH)
      .pipe(gulpStylus())
      .pipe(gulpMinifyCss())
      .pipe(gulpConcat('custom.css'))
      .pipe(gulp.dest(ASSETS_PATH + 'dist/css/'));
});

gulp.task('libCss', function() {
  return gulp.src(getLibPaths(CSS_LIBS))
      .pipe(gulpConcat('libs.css'))
      .pipe(gulp.dest(ASSETS_PATH + 'dist/css/'));
});

// Combine custom styles and library styles into one file, depends the handling of custom and library CSS
gulp.task('combineCss', ['customStylus', 'libCss'], function() {
  return gulp.src(ASSETS_PATH + 'dist/css/{libs.css,custom.css}')
      .pipe(gulpConcat('all.css'))
      .pipe(gulp.dest(ASSETS_PATH + '/dist/css/'))
});

gulp.task('customJade', function() {
  return gulp.src(CUSTOM_JADE_PATH)
      .pipe(gulpJade())
      .pipe(gulp.dest(ASSETS_PATH + '/dist/html/'))
});

// Watch for changes, compile source files and combine into the final JS and CSS file
gulp.task('watch', function() {
  gulp.watch(CUSTOM_COFFEE_PATH, ['customCoffee', 'combineJs']);
  gulp.watch(CUSTOM_STYLUS_PATH, ['customStylus', 'combineCss']);
  gulp.watch(CUSTOM_JADE_PATH,   ['customJade'])
});

gulp.task('default',
    ['customCoffee', 'libJs', 'customStylus', 'libCss', 'combineJs', 'combineCss', 'customJade', 'watch']);
