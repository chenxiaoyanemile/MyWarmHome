package com.example.sweetgirl.mywarmhome.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.sweetgirl.mywarmhome.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *  2017/3/16.
 */

public class ShareRecyclerViewAdapter extends RecyclerView.Adapter<ShareRecyclerViewAdapter.ViewHolder>{


    private ArrayList<String> datas;
    private Context context;

    private LayoutInflater layoutInflater;
    private VolleySingleton volleySingleton;
    private ImageLoader imageLoader;
    private DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    private int previousPosition=0;



    public ShareRecyclerViewAdapter(Context context,ArrayList<String> datas){
        this.context=context;
        this.datas=datas;
        layoutInflater = LayoutInflater.from(context);
        volleySingleton = VolleySingleton.getInstance(context);
        imageLoader = volleySingleton.getImageLoader();
    }

    /*public void setTextImages(ArrayList<TextImage> textImages){
        this.textImages=textImages;
        notifyItemMoved(0,textImages.size());
    }*/

    /**
     *相当于getView 方法中创建view和ViewHolder
     * * @param
     *
     * */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView=layoutInflater.inflate(R.layout.item_share, parent,false);
        ViewHolder viewHolder=new ViewHolder(itemView);
        return viewHolder;
    }

    /**
     * 相当于getView 方法中创建view和ViewHolder
     * @param
     *
     */

    @Override
    public void  onBindViewHolder(ViewHolder holder, int position){
        String data=datas.get(position);
        holder.mDep.setText(data);
       /* TextImage currentTextImage=textImages.get(position);
        holder.mText.setText(currentTextImage.getName());
        holder.mDep.setText(currentTextImage.getDep());

        holder.itemView.setTag(position);

        String url=currentTextImage.getImage();
        loadImages(url,holder);*/

    }

    /*private void loadImages(String urlThumbnail, final ViewHolder holder) {
        if (!urlThumbnail.equals(Constants.NA)) {
            imageLoader.get(urlThumbnail, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                    holder.mImage.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }
    }*/

    /**
     *相当于getView 方法中创建view和ViewHolder
     * @param
     */
    @Override
    public int  getItemCount(){
        return datas.size();
        //return textImages.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mDep;
        TextView mText;
        ImageView mImage;
        TextView mContent;

        public ViewHolder(View itemView){
            super(itemView);
            mText = (TextView)itemView.findViewById(R.id.cgt_tv_me_userName);
            mImage = (ImageView)itemView.findViewById(R.id.iv_item_share);
            mDep=(TextView)itemView.findViewById(R.id.tv_item_share_time);
            mContent=(TextView) itemView.findViewById(R.id.tv_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v,(int)v.getTag());
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        public void OnItemClick(View view,int position);
    }

    private PageRecycerViewAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(PageRecycerViewAdapter.OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }


}
