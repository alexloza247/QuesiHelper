export interface PrintSheetPlugin {
    print(): Promise<{ ok: boolean }>;
}
