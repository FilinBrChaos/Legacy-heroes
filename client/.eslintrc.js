const eslintrcStrict = require('./.eslintrc.strict');

const eslintrcRules = eslintrcStrict ? Object.assign({}, eslintrcStrict) : {};
const plugins = Array.isArray(eslintrcRules.plugins) ? eslintrcRules.plugins.slice() : [];
plugins.push('only-warn');

module.exports = Object.assign({}, eslintrcRules, { plugins });
