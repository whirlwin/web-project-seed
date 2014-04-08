const gulp          = require('gulp');
const gulpCoffee    = require('gulp-coffee');
const gulpConcat    = require('gulp-concat');
const gulpIf        = require('gulp-if');
const gulpJade      = require('gulp-jade');
const gulpMinifyCss = require('gulp-minify-css');
const gulpOrder     = require('gulp-order');
const gulpStylus    = require('gulp-stylus');
const gulpUglify    = require('gulp-uglify');
const env           = require('./env');

const ASSETS_PATH        = 'src/main/webapp/assets/';
const DIST_PATH          = ASSETS_PATH + 'dist/';
const DIST_JS_PATH       = DIST_PATH + 'js/';
const DIST_CSS_PATH      = DIST_PATH + 'css/';
const DIST_HTML_PATH     = DIST_PATH + 'html/';
const LIB_PATH           = ASSETS_PATH + 'lib/';
const CUSTOM_COFFEE_PATH = [ASSETS_PATH + 'scripts/**/*.coffee'];
const CUSTOM_STYLUS_PATH = [ASSETS_PATH + 'styles/**/*.styl'];
const CUSTOM_JADE_PATH   = [ASSETS_PATH + 'views/**/*.jade']

gulp.task('customCoffee', function() {
  return gulp.src(CUSTOM_COFFEE_PATH)
      .pipe(gulpCoffee())
      .pipe(gulpIf(env.compressed, gulpUglify()))
      .pipe(gulpConcat('custom.js'))
      .pipe(gulp.dest(DIST_JS_PATH));
});

gulp.task('libJs', function() {
  return gulp.src(getLibPath('.js'))
      .pipe(gulpConcat('libs.js'))
      .pipe(gulp.dest(DIST_JS_PATH))
});

// Combine custom scripts and library scripts into one file, depends on the handling of custom and library JS
gulp.task('combineJs', ['customCoffee', 'libJs'], function() {
  return gulp.src(DIST_JS_PATH + '*.js')
      .pipe(gulpOrder(['libs.js', 'custom.js']))
      .pipe(gulpConcat('all.js'))
      .pipe(gulp.dest(DIST_PATH));
});

gulp.task('customStylus', function() {
  return gulp.src(CUSTOM_STYLUS_PATH)
      .pipe(gulpStylus())
      .pipe(gulpMinifyCss())
      .pipe(gulpConcat('custom.css'))
      .pipe(gulp.dest(DIST_CSS_PATH));
});

gulp.task('libCss', function() {
  return gulp.src(LIB_PATH + '/**/*.css')
      .pipe(gulpConcat('libs.css'))
      .pipe(gulp.dest(DIST_CSS_PATH));
});

// Combine custom styles and library styles into one file, depends the handling of custom and library CSS
gulp.task('combineCss', ['customStylus', 'libCss'], function() {
  return gulp.src(DIST_CSS_PATH + '*.css')
      .pipe(gulpOrder(['libs.css', 'custom.css']))
      .pipe(gulpConcat('all.css'))
      .pipe(gulp.dest(DIST_PATH))
});

gulp.task('customJade', function() {
  return gulp.src(CUSTOM_JADE_PATH)
      .pipe(gulpJade())
      .pipe(gulp.dest(DIST_HTML_PATH))
});

// Watch for changes, compile source files and combine into the final JS and CSS file
gulp.task('watch', function() {
  gulp.watch(CUSTOM_COFFEE_PATH, ['customCoffee', 'combineJs']);
  gulp.watch(CUSTOM_STYLUS_PATH, ['customStylus', 'combineCss']);
  gulp.watch(CUSTOM_JADE_PATH,   ['customJade'])
});

gulp.task('default', ['customCoffee', 'libJs', 'customStylus', 'libCss', 'combineJs', 'combineCss', 'customJade','watch']);

function getLibPath(extension) {
  return env.compressed ?
      LIB_PATH + '**/*.min' + extension :
      [LIB_PATH + '**/*' + extension, '!' + LIB_PATH + '**/*.min' + extension];
}
