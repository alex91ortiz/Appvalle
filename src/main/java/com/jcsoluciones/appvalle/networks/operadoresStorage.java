package com.jcsoluciones.appvalle.networks;

import android.content.Context;
import android.os.Handler;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42Exception;
import com.shephertz.app42.paas.sdk.android.storage.Storage;
import com.shephertz.app42.paas.sdk.android.storage.StorageService;

import org.json.JSONObject;

/**
 * Created by root on 1/06/17.
 */

public class operadoresStorage {
    /** The storage service. */
    private StorageService storageService;
    private String collectionName="operadores";

    public operadoresStorage(Context context) {
        App42API.initialize(context, Constantes.App42ApiKey, Constantes.App42ApiSecret);
    }

    public void insertar(final JSONObject json, final interfaceStorage callBack){
        final Handler callerThreadHandler = new Handler();
        new Thread() {
            @Override
            public void run() {
                try {
                    final Storage response = storageService.insertJSONDocument(Constantes.dbName, collectionName, json);
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onDocumentInserted(response);
                        }
                    });
                } catch (final App42Exception ex) {
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack != null) {
                                callBack.onInsertionFailed(ex);
                            }
                        }
                    });
                }
            }
        }.start();
    }

    public void actualizar(final String id,final JSONObject json, final interfaceStorage callBack){
        final Handler callerThreadHandler = new Handler();
        new Thread() {
            @Override
            public void run() {
                try {
                    final Storage response = storageService.updateDocumentByDocId(Constantes.dbName, collectionName, id,json);
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onUpdateDocSuccess(response);
                        }
                    });
                } catch (final App42Exception ex) {
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack != null) {
                                callBack.onUpdateDocFailed(ex);
                            }
                        }
                    });
                }
            }
        }.start();
    }

    public void borrar(final String id, final interfaceStorage callBack){
        final Handler callerThreadHandler = new Handler();
        new Thread() {
            @Override
            public void run() {
                try {
                    final Storage response = (Storage) storageService.deleteDocumentById(Constantes.dbName, collectionName, id);
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onDocumentDelete(response);
                        }
                    });
                } catch (final App42Exception ex) {
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack != null) {
                                callBack.onDeleteFailed(ex);
                            }
                        }
                    });
                }
            }
        }.start();
    }

    public void buscar(final String key,final String value, final interfaceStorage callBack){
        final Handler callerThreadHandler = new Handler();
        new Thread() {
            @Override
            public void run() {
                try {
                    final Storage response =  storageService.findDocumentByKeyValue(Constantes.dbName, collectionName, key,value);
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onFindDocSuccess(response);
                        }
                    });
                } catch (final App42Exception ex) {
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack != null) {
                                callBack.onFindDocFailed(ex);
                            }
                        }
                    });
                }
            }
        }.start();
    }

    public void lista(final interfaceStorage callBack){
        final Handler callerThreadHandler = new Handler();
        new Thread() {
            @Override
            public void run() {
                try {
                    final Storage response =  storageService.findAllDocuments(Constantes.dbName, collectionName);
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onFindDocSuccess(response);
                        }
                    });
                } catch (final App42Exception ex) {
                    callerThreadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (callBack != null) {
                                callBack.onFindDocFailed(ex);
                            }
                        }
                    });
                }
            }
        }.start();
    }

}
