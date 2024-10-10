import { defineConfig } from '@playwright/test';

export default defineConfig({
  workers: 4, // Укажите нужное количество потоков
});