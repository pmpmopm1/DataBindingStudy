package databinding.example.com.java.data;

import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import databinding.example.com.BR;
import databinding.example.com.java.util.ObservableViewModel;

public class ProfileObservableViewModel extends ObservableViewModel {

    public void increment() {
        likes.set(likes.get()+1);
    }

    public ObservableField name = new ObservableField("java");
    public ObservableField lastName = new ObservableField("viewmodel");
    public ObservableInt likes = new ObservableInt(0);

    public void onLike() {
        increment();
        notifyPropertyChanged(BR.popularity);
    }

    @Bindable
    public Popularity getPopularity() {
        Popularity result;
        if (likes.get() > 9){
            result = Popularity.STAR;
        }else if(likes.get() > 4 && likes.get() <= 9){
            result = Popularity.POPULAR;
        }else{
            result = Popularity.NORMAL;
        }

        return result;
    }
}
