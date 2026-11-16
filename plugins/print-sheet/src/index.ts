import { registerPlugin } from '@capacitor/core';
import type { PrintSheetPlugin } from './definitions';

const PrintSheet = registerPlugin<PrintSheetPlugin>('PrintSheet');

export * from './definitions';
export { PrintSheet };
