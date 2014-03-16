const gulp          = require('gulp');
const gulpCoffee    = require('gulp-coffee');
const gulpConcat    = require('gulp-concat');
const gulpIf        = require('gulp-if');
const gulpMinifyCss = require('gulp-minify-css');
const gulpStylus    = require('gulp-stylus');
const gulpUglify    = require('gulp-uglify');
const env           = require('./env');

const ASSETS_PATH         = 'src/main/webapp/assets/';
const DIST_PATH           = ASSETS_PATH + 'dist/';
const LIB_PATH            = ASSETS_PATH + 'lib/' + (env.compressed ? 'minified' : 'original');
const CUSTOM_SCRIPTS_PATH = [ASSETS_PATH + 'scripts/**/*.coffee'];
const CUSTOM_STYLES_PATH  = [ASSETS_PATH + 'styles/**.styl'];

gulp.task('customScripts', function() {
  return gulp.src(CUSTOM_SCRIPTS_PATH)
      .pipe(gulpCoffee())
      .pipe(gulpIf(env.compressed, gulpUglify()))
      .pipe(gulpConcat('custom.js'))
      .pipe(gulp.dest(DIST_PATH));
});

gulp.task('libScripts', function() {
  return gulp.src(LIB_PATH + '/**/*.js')
      .pipe(gulpConcat('libs.js'))
      .pipe(gulp.dest(DIST_PATH))
});

gulp.task('customStyles', function() {
  return gulp.src(CUSTOM_STYLES_PATH)
      .pipe(gulpStylus())
      .pipe(gulpMinifyCss())
      .pipe(gulpConcat('custom.css'))
      .pipe(gulp.dest(DIST_PATH));
});

gulp.task('libStyles', function() {
  return gulp.src(LIB_PATH + '/**/*.css')
      .pipe(gulpConcat('libs.css'))
      .pipe(gulp.dest(DIST_PATH));
});

gulp.task('watch', function() {
  gulp.watch(CUSTOM_SCRIPTS_PATH, ['customScripts']);
  gulp.watch(CUSTOM_STYLES_PATH,  ['customStyles']);
});

gulp.task('default', ['customScripts', 'libScripts', 'customStyles', 'libStyles','watch']);
