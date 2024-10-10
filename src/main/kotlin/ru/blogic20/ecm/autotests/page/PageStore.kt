//package ru.blogic20.ecm.pages
//
//import ru.blogic20.ecm.autotests.page.*
////import ru.blogic20.ecm.pages.elements.DocTablesPage
////import ru.blogic20.ecm.pages.elements.TablePage
////import ru.blogic20.ecm.pages.inputs.*
//
///**
// * Класс-хранилище экземпляров Page Objects.
// */
//object PageStore {
//
//    /**
//     * Путь к папке с файлами конфигураций (xpath) страниц.
//     */
//    private const val PATH_TO_PAGE_OBJECTS = "data/page_configurations"
//
//    /**
//     * Класс-хранилище экземпляров Page Objects для потока.
//     */
//
//    /**
//     * Хранилище наборов пейдж-обджектов для потока.
//     */
//    private val localStore: ThreadLocal<> = ThreadLocal()
//
//    /**
//     * @return  Возвращает набор пейдж-обджектов для конкретного потока.
//     */
//    fun getLocal(): InnerStore {
//        if (localStore.get() == null) localStore.set(InnerStore())
//        return localStore.get()
//    }
//}