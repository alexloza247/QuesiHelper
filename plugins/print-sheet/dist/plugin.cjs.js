'use strict';

var core = require('@capacitor/core');

const PrintSheet = core.registerPlugin('PrintSheet', {
    web: () => Promise.resolve().then(function () { return web; }).then(m => new m.PrintSheetWeb()),
});

class PrintSheetWeb extends core.WebPlugin {
    async print() {
        throw this.unavailable('La impresión solo está disponible en la app');
    }
}

var web = /*#__PURE__*/Object.freeze({
    __proto__: null,
    PrintSheetWeb: PrintSheetWeb,
});

exports.PrintSheet = PrintSheet;
