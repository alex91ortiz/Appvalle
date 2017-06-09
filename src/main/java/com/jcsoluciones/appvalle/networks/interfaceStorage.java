package com.jcsoluciones.appvalle.networks;

import com.shephertz.app42.paas.sdk.android.App42Exception;
import com.shephertz.app42.paas.sdk.android.storage.Storage;

import org.json.JSONObject;

/**
 * Created by ipor00272 on 8/06/17.
 */


    public interface interfaceStorage
    {

        /**
         * On document inserted.
         *
         * @param response the response
         */
        public void onDocumentInserted(Storage response);

        /**
         * On update doc success.
         *
         * @param response the response
         */
        public void onUpdateDocSuccess(Storage response);

        /**
         * On find doc success.
         *
         * @param response the response
         */
        public void onFindDocSuccess(Storage response);

        /**
         * On document inserted.
         *
         * @param response the response
         */
        public void onDocumentDelete(Storage response);
        /**
         * On insertion failed.
         *
         * @param ex the ex
         */
        public void onInsertionFailed(App42Exception ex);

        /**
         * On find doc failed.
         *
         * @param ex the ex
         */
        public void onFindDocFailed(App42Exception ex);

        /**
         * On update doc failed.
         *
         * @param ex the ex
         */
        public void onUpdateDocFailed(App42Exception ex);
        /**
         * On insertion failed.
         *
         * @param ex the ex
         */
        public void onDeleteFailed(App42Exception ex);
    }
